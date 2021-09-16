package com.beta.replyservice;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.beta.replyservice.util.MD5HashAlgorithm;

@RestController
public class ReplyController {

	private static final Charset UTF_8 = StandardCharsets.UTF_8;

	@GetMapping("/v1/reply")
	public ReplyMessage replyingV1() {
		return new ReplyMessage("Message is empty", 200);
	}

	@GetMapping("/v1/reply/{message}")
	public ReplyMessage replyingV1(@PathVariable String message) {
		return new ReplyMessage(message, 200);
	}

	@GetMapping("/v2/reply")
	public ReplyMessage replyingV2() {
		return new ReplyMessage("Message is empty", 200);
	}

	@GetMapping("/v2/reply/{message}")
	public ReplyMessage replyingV2(@PathVariable String message) {
		String[] items = message.split("-");
		char[] rules = items[0].toCharArray();
		String input = items[1];
		for (char ch : rules) {
			if (ch == '1') {
				// reverse string
				byte[] inputAsBytesArray = input.getBytes();
				byte[] result = new byte[inputAsBytesArray.length];
				for (int i = 0; i < inputAsBytesArray.length; i++)
					result[i] = inputAsBytesArray[inputAsBytesArray.length - i - 1];
				input = new String(result);
			} else if (ch == '2') {
				// MD5 hash algorithm
				byte[] md5InBytes = MD5HashAlgorithm.digest(input.getBytes(UTF_8));
				input = MD5HashAlgorithm.bytesToHex(md5InBytes);
			} else {
				return new ReplyMessage("Invalid Input", 400);
			}
			//We Can More else if conditions to add new rules with out disturbing existing rules with minimal changes.
		}
		return new ReplyMessage(input, 200);
	}
}