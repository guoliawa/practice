package web.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class ConnectAsync {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String host = "localhost";
		int port = 8011;
		if (args.length == 2) {
			host = args[0];
			port = Integer.parseInt(args[1]);
		}

		InetSocketAddress addr = new InetSocketAddress(host, port);
		SocketChannel sc = SocketChannel.open();
		
		
		Selector selector = Selector.open();
		selector.select();
		
		sc.configureBlocking(false);
		System.out.println("initiating connection");
		sc.connect(addr);

		while (!sc.finishConnect()) {
			doSomethingUnseful();
		}
		System.out.println("connection established");
		// Do something with the connected socket
		// The SocketChannel is still nonblocking
		sc.close();

	}

	private static void doSomethingUnseful() {
		// TODO Auto-generated method stub
		System.out.println("doing something useless");
	}

}
