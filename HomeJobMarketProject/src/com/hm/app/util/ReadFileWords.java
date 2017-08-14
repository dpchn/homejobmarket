package com.hm.app.util;

import java.io.*;
import java.util.*;

public class ReadFileWords {

	public static Set<String> offensiveWordSet = new HashSet<>();

	public static String OFFENSIVE_WORDS_FILE = "words.txt";

	static {
		BufferedReader br = null;
		try {

			br = new BufferedReader(
					new InputStreamReader(ReadFileWords.class.getResourceAsStream(OFFENSIVE_WORDS_FILE)));

			br.lines().forEach(offensiveWordSet::add);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public boolean isContainsOffensiveWord(String str) throws IOException {

		boolean containsOffensive = Arrays.asList(str.split(" ")).stream()
				.anyMatch(x -> offensiveWordSet.contains(x.trim()));

		return containsOffensive;
	}

}
