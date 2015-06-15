package web.test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	private ExecutorService executors = Executors.newFixedThreadPool(10);
	private boolean isRunning = true;

	public static void main(String[] args) throws Exception, IOException {
		new Server().launch(9292);
	}

	public void launch(int port) throws IOException {
		ServerSocket sso = new ServerSocket(port);
		while (isRunning) {
			Socket s = sso.accept();
			executors.execute(new Worker(s));
		}
	}

	private class Worker implements Runnable {
		private LineNumberReader in = null;
		private BufferedWriter out = null;

		Worker(Socket s) throws IOException {
			in = new LineNumberReader(new InputStreamReader(s.getInputStream()));
		}

		public void run() {
			while (isRunning) {
				try {
					// blocking read of a request (line)
					String request = in.readLine();

					// processing the request
					String response = request;

					// return the response
					out.write(response);
					out.flush();
				} catch (Exception e) {
					System.out.println("IO Exeception");
					isRunning = false;
				}
			}
			
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
