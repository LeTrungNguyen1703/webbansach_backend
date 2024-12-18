package com.example.webbansach_backend;

import com.example.webbansach_backend.entity.TheLoai;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebbansachBackendApplicationTests {

	@Test
	void contextLoads() {

		TheLoai theLoai = TheLoai.builder()
				.maTheLoai(1)
				.tenTheLoai("chu ba bi")
				.build();
		System.out.println(theLoai);
	}

}
