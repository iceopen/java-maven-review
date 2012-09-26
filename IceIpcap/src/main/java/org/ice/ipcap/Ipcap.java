package org.ice.ipcap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ice.jdbc.push;
import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.protocol.network.Ip4;

public class Ipcap {
	public static void main(String[] args) {

		List<PcapIf> alldevs = new ArrayList<PcapIf>(); // Will be filled with
		// NICs
		StringBuilder errbuf = new StringBuilder(); // For any error msgs
		int r = Pcap.findAllDevs(alldevs, errbuf);
		if (r == Pcap.NOT_OK || alldevs.isEmpty()) {
			System.err.printf("Can't read list of devices, error is %s",
					errbuf.toString());
			return;
		}

		System.out.println("Network devices found:");

		int i = 0;
		for (PcapIf device : alldevs) {
			String description = (device.getDescription() != null) ? device
					.getDescription() : "No description available";
			System.out.printf("#%d: %s [%s]\n", i++, device.getName(),
					description);
		}

		PcapIf device = alldevs.get(0); // We know we have atleast 1 device
		System.out.printf("\nChoosing '%s' on your behalf:\n",
				(device.getDescription() != null) ? device.getDescription()
						: device.getName());
		int snaplen = 64 * 1024; // Capture all packets, no trucation
		int flags = Pcap.MODE_PROMISCUOUS; // capture all packets
		int timeout = 10 * 1000; // 10 seconds in millis
		Pcap pcap = Pcap.openLive(device.getName(), snaplen, flags, timeout,
				errbuf);

		if (pcap == null) {
			System.err.printf("Error while opening device for capture: "
					+ errbuf.toString());
			return;
		}

		PcapPacketHandler<String> jpacketHandler = new PcapPacketHandler<String>() {

			public void nextPacket(PcapPacket packet, String user) {
				Ip4 ip = new Ip4();
				if (packet.hasHeader(ip)) {
					checkIp(ip);
				}
			}
		};
		pcap.loop(-1, jpacketHandler, "jNetPcap rocks!");
		pcap.close();
	}

	public static void checkIp(Ip4 ip) {
		String regex = "\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b";
		Pattern p = Pattern.compile(regex);
		String ipData = ip.toString();
		Matcher m = p.matcher(ipData);
		while (m.find()) {
			if (Ip.isInnerIP(m.group())) {
				// 内网
			} else {
				// 外网IP地址 m.group()
				// 时间 new Date().getTime();
				// 流量大小 ipData.split("Ip:")[9].split("length = ")[1]
				// 642 733
				System.out.println(m.group());
				push.add(m.group(),
						ipData.split("Ip:")[9].split("length = ")[1],
						new Date().getTime(), ipData);
			}
		}
	}
}
