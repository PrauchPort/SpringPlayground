package skiller.skiller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillerController {

	@GetMapping("/")
	public String getHome()
	{
		return "test";
	}
	
	
}
