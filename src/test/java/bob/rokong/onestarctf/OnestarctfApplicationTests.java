package bob.rokong.onestarctf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bob.rokong.onestarctf.utils.CryptoUtil;

@SpringBootTest
class OnestarctfApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(OnestarctfApplicationTests.class);

	@Autowired
	private CryptoUtil cryptoUtil;

	/*
	// implementation("com.h2database:h2") first.
	@Test
	public void webConsoleEncryption() {
		String raw = "dlaghdfhrdlaghdfhr";
		String enc = org.h2.server.web.WebServer.encodeAdminPassword(raw);
		log.info("enc: {}", enc);
	}
	*/

	@Test
	public void cryptoEncDec() {
		log.info("KEY: {}", cryptoUtil.KEY);
		String flag = "IF_THIS_IS_FLAG...";

		// Encryption
		String enc = cryptoUtil.encrypt(flag);
		log.info("enc: {}", enc);

		// Decryption
		String dec = cryptoUtil.decrypt(enc);
		log.info("dec: {}", dec);

		assertEquals(flag, dec);
	}
}
