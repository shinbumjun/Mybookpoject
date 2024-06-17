package com.bum.jun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.Servlet;
import javax.servlet.ServletException;	
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/openapi/dataServlet")
public class Apitest extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	public Apitest() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml;charset=UTF-8");

		BufferedReader br = null;
		try {
			String search = "부산";
			String urlstr = "https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=V2soxVa%2FBMDzYDIk9IbGZTgcZeSQ6GIdaZnsBoez7GPAUwIQ%2F6MT%2FjyI5mtbTgXy24zNvlE9d5%2FEF0Y0YoKoNQ%3D%3D&returnType=xml&numOfRows=100&pageNo=1&sidoName="
					+ URLEncoder.encode(search,"UTF-8")+ "&ver=1.0";
			URL url = new URL(urlstr);
			
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			String result = "";
			String line;
			
			while ((line = br.readLine()) != null) {
				result = result + line + "\n";
			}
			response.getWriter().append(result);
		} catch (Exception e) {
			response.getWriter().append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><response><header><resultCode>-999</resultCode><resultMsg>알 수 없는 오류</resultMsg></header></response>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}