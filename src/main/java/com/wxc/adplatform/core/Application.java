package com.wxc.adplatform.core;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.wxc.adplatform.util.EnvUtils;

@EnableAutoConfiguration
@ImportResource("classpath:spring.xml")
@EnableAsync
@EnableScheduling
public class Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	private static boolean isMainNode = false;

	private static boolean isTaskNode = false;

	public static void main(String[] args) throws IOException {

		LOGGER.info("Begin to run wxc Ad product!");

		try {
			isMainNode = EnvUtils.isMainNode(new Application());

			isTaskNode = EnvUtils.isTaskNode(new Application());

			// 创建文件夹
			if (isTaskNode || isMainNode) {
				File file = new File("adfileinfo");
				if (!file.exists()) {
					file.mkdirs();
				}
			}

			LOGGER.info("current node is main node:{} ", isMainNode);
		} catch (Exception e) {
			LOGGER.error("current port exception{}", e);
			// 获取端口异常，退出
			// System.exit(100);
		}

		// isTaskNode = true;
		// if (isTaskNode){
		// File file = new File("adfileinfo");
		// if (!file.exists()) {
		// file.mkdirs();
		// }
		// }

		SpringApplication.run(Application.class, args);

		LOGGER.info("===============================================!");

	}

	public static boolean isMainNode() {
		return isMainNode;
	}

	public static boolean isTaskNode() {
		return isTaskNode;
	}
}
