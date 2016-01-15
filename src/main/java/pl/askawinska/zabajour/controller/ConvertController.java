package pl.askawinska.zabajour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pl.askawinska.zabajour.converter.FrenchConverter;
import pl.askawinska.zabajour.dto.ResponseDto;

@RestController
public class ConvertController {

	@Autowired
	FrenchConverter converter;

	@RequestMapping("/french/{text}")
	public @ResponseBody ResponseDto convert(@PathVariable final String text) {
		return new ResponseDto.Builder().setOriginal(text).setTranslated(converter.convert(text)).build();
	}

}
