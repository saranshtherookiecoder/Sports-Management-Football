package com.freeware.football.utils;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Utils {

	public static Path getPath(Root root, String columnPath) {
		log.info("columnpath :{}", columnPath);
		Path p = root;
		if (!columnPath.contains(".")) {
			return root.get(columnPath);
		}
		String[] levels = columnPath.split("\\.");

		for (int i = 0; i < levels.length; i++) {
			p = p.get(levels[i]);
		}
		return p;

	}
}
