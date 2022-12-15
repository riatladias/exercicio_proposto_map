package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> votos = new LinkedHashMap<>();

		System.out.print("Enter file full path: ");
		System.out.println("c:\\temp\\in.txt");
		String path = "c:\\temp\\in.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();

			while (line != null) {

				String[] fields = line.split(",");

				String name = fields[0];

				if (votos.containsKey(name)) {
					Integer count = Integer.parseInt(fields[1]) + votos.get(name);
					votos.put(name, count);
				} else {
					votos.put(name, Integer.parseInt(fields[1]));
				}

				line = br.readLine();
			}

			for (String key : votos.keySet()) {
				System.out.println(key + ": " + votos.get(key));
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		sc.close();
	}

}
