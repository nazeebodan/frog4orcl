/**
 * 
 */
package com.frog4orcl.framework.core.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.frog4orcl.framework.exception.DatabaseException;

/**
 * @说明: 读取配置文件
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 10, 2011 4:35:36 PM
 * @version: 1.0
 */
public class DBProperties {

	private static Logger logger = Logger.getLogger(DBProperties.class);
	// 配置文件
	public static final String CONF_FILE_PATH = "/dbconfig.properties";
	
	private static DBProperties instance;

	private DBProperties() {
	}

	public static DBProperties getInstance() {
		if (instance == null) {
			instance = new DBProperties();
		}
		return instance;
	}

	public static void main(String[] args) {
		DBProperties test = DBProperties.getInstance();
		Properties prop = test.getDBConfig();
		String url = prop.getProperty("url");
		System.out.println(url.replaceAll("<server>", "172.16.40.26:1521")
				.replaceAll("<dbname>", "orcl"));

	}

	/**
	 * 获取DB的配置文件信息 其中key含有url,driver
	 * 
	 * @return
	 */
	public Properties getDBConfig() {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = this.getClass().getResourceAsStream(CONF_FILE_PATH);
			prop.load(input);
			// Set<Entry<Object, Object>> set = prop.entrySet();
			// Iterator<Entry<Object, Object>> it = set.iterator();
			// while (it.hasNext()) {
			// Map.Entry<Object, Object> entry = it.next();
			// System.out.println(entry.getKey() + "||" + entry.getValue());
			// }
			return prop;
		} catch (Exception e) {
			logger.error("init DB config fail:" + e);
			throw new DatabaseException(e.getMessage());
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				logger.error("init DB config,close inputstream fail:" + e);
				throw new DatabaseException(e.getMessage());
			}
		}
	}
}
