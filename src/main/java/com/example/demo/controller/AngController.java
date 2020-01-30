package com.example.demo.controller;

import java.util.Date;

import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AngService;
import com.example.models.ResponseBean;
import com.example.models.SignUpBeanEntity;

import io.sentry.Sentry;

@RestController
public class AngController {

	@Autowired
	AngService signupServce;

	@GetMapping("/api/sentryTest")
	public void sentryTest() {
		Sentry.init("https://f979d9d320c64f4a80cb899b46951ef8@sentry.io/1364987");
		try {
			int i = 10 / 0;
			System.out.println("arithmetic Exception");
		} catch (Exception e) {
			Sentry.capture(e);
		}
	}

	@PostMapping("/api/signUp")
	public String signUp(@RequestBody SignUpBeanEntity signBean, BindingResult bindingResult) {
		return signupServce.signUpUser(signBean);
	}

	@PostMapping("api/login")
	public ResponseBean login(@RequestBody SignUpBeanEntity model) {
		Date lastLoginDate = signupServce.loginUpUser(model);
		ResponseBean response = new ResponseBean();
		if (lastLoginDate != null) {
			response.setLastLoginDate(lastLoginDate);
			response.setStatus("Success");
		}
		return response;
	}

	@PutMapping("api/updateProfile")
	public ResponseBean updateProfile(@RequestBody SignUpBeanEntity model) {
		System.out.println("update model:::::::::::::;" + model);
		return signupServce.updateProfile(model);
	}

	@GetMapping("api/profile/{email}")
	public SignUpBeanEntity getProfile(@QueryParam("email") String email) {
		return signupServce.getProfile(email);
	}

	/*
	 * @GetMapping("api/getPhoto") public @ResponseBody byte[]
	 * getFile(HttpServletResponse response) throws Exception {
	 * 
	 * String filePath = "F:/Photos/DST/Dasara 18/IMG_20181012_163950997.jpg"; File
	 * file = new File(filePath); if(file.exists()) { String contentType =
	 * "application/octet-stream"; response.setContentType(contentType);
	 * OutputStream out = response.getOutputStream(); FileInputStream in = new
	 * FileInputStream(file); // copy from in to out IOUtils.copy(in, out);
	 * out.close(); in.close(); } String filePath =
	 * "F:/Photos/DST/Dasara 18/IMG_20181012_163950997.jpg"; BufferedImage image =
	 * new BufferedImage(300, 300, 50); //resizeImage(300, 300, filePath);
	 * ByteArrayOutputStream os = new ByteArrayOutputStream(); ImageIO.write(image,
	 * "jpg", os); return os.toByteArray(); }
	 */
	
	@PostMapping("xml")
	public void getxml(@FormParam("signUpBeanEntity") SignUpBeanEntity bean) {
		System.out.println(bean.getEmail());
	}
}
