package com.smishra.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.smishra.exceptions.ReturnCodes;
import com.smishra.utils.StringUtils;

@Path("/")
public class PyramidWord{
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getTest(){
		return "ok";
	}
	@POST
	@Path("/check")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String checkPyramidWord(String req) {
		String word = "";
		try{
			word = StringUtils.getValue(req);
		} catch (Exception e) {
			return ReturnCodes.PARSE_ERROR;
		}
		if(!StringUtils.validateInput(word)) {
			return ReturnCodes.INVALID_WORD;
		}
		Map<Character,Integer> characterCount = StringUtils.charCountMap(word);
		List<Integer> countList = new ArrayList<Integer>(characterCount.values());
		Collections.sort(countList);
		if(!StringUtils.hasDuplicates(countList) && !word.contains(" ")) {
			return ReturnCodes.PYRAMID_WORD;
		} else {
			return ReturnCodes.NOT_PYRAMID_WORD;
		}
	}

}
