package laszlopapp.realEstate;
import laszlopapp.realEstate.model.CalculationResultLog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RealEstateApplicationTests {

	private MediaType contentType = new MediaType(MediaType.TEXT_HTML.getType(),
			MediaType.TEXT_HTML.getSubtype(),
			Charset.forName("utf8"));

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	CalculationResultLog calculationResultLog = new CalculationResultLog(47, 46, 23.643,
			"E", 17, 21, 23.234, "W",
			230.4, 234561);

	@Test
	public void testPageOfRealEstatesSuccess() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andDo(print());
	}

	@Test
	public void testGetCoordinatesNoParameterFailure() throws Exception {
		mockMvc.perform(post("/calculatePrice"))
				.andExpect(status().is4xxClientError())
				.andDo(print());
	}
}
