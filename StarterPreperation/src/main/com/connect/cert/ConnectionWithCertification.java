package com.connect.cert;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Base64;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class ConnectionWithCertification {

	private static final String KEYSTORE_PATH = "C:\\Users\\mrinal.kanti.mondal\\Documents\\OneDrive_1_6-4-2019\\BIGCXIWS.p12";
	private static final String keyStorePass = "qwerty";
	private static final String requestURL = "https://agwa.pg.com:44311/SOAP/PRIMENA/BAT?senderParty=P_PDM_B2B_NA_PRIME_DTC_BIGC&senderService=PG_PDM_B2B_NA_PRIME_DTC_BIGC&interface=SI_OA_DTCXML&interfaceNamespace=http://pg.com/xi/pdm/b2b/global/dtc/prime&receiverParty=&receiverService=&nosoap=true";
	private static final String userId = "BIGCXIWS";
	private static final String password = "aHX6x?6f";

	public static void main(String[] args) throws IOException, 
	UnrecoverableKeyException, KeyManagementException, KeyStoreException, 
	NoSuchAlgorithmException, CertificateException{		
		URL url = new URL(requestURL);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		
		connection.setDefaultHostnameVerifier(getHostNames());

		if (connection instanceof HttpsURLConnection) {
			((HttpsURLConnection) connection).setSSLSocketFactory(getSSLContext().getSocketFactory());
		}
		
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Accept", "application/xml");
		connection.setRequestProperty("Content-Type", "application/xml; utf-8");
		connection.setRequestProperty ("Authorization", getBasicAuthrization());
		connection.setDoOutput(true);
		connection.setDoInput(true);
	    String body = "<?xml version='1.0' encoding='UTF-8' standalone='yes'?> <ZSHPMNT5> <IDOC> <EDI_DC40> <MESTYP>ZPICRQ</MESTYP> <RCVPRN>PR</RCVPRN> <REFMES>RPWC304_01</REFMES> </EDI_DC40> <E1EDT20> <EXTI1>1559743648154</EXTI1> <Z1EDTAD> <HAULIER>0020638249</HAULIER> <LFART>GIL</LFART> <PLNDCHKDATE>20190531</PLNDCHKDATE> <PLNDCHKTIME>0</PLNDCHKTIME> <PLNDSTRDATE>20190531</PLNDSTRDATE> <PLNDSTRTIME>0</PLNDSTRTIME> <LGORT>DCOM</LGORT> </Z1EDTAD> <E1EDL20> <VBELN>106</VBELN> <Z1EDLHD> <STOP>D</STOP> <BSTNK>106</BSTNK> <ZZAUDAT>20190531</ZZAUDAT> </Z1EDLHD> <E1ADRM1> <PARTNER_Q>WE</PARTNER_Q> <PARTNER_ID>2</PARTNER_ID> <NAME1>Mrinal Mondal</NAME1> <STREET1>ADDLINE1</STREET1> <STREET2>ADDLINE2</STREET2> <STREET3></STREET3> <POSTL_COD1>78946</POSTL_COD1> <CITY1>City1</CITY1> <TELEPHONE1>7894561345</TELEPHONE1> <TELEFAX></TELEFAX> <COUNTRY1>US</COUNTRY1> <REGION>AK</REGION> </E1ADRM1> <E1EDL24> <POSNR>000010</POSNR> <MATNR>000000000000SM13</MATNR> <WERKS>C304</WERKS> <LGMNG>1</LGMNG> </E1EDL24> <E1EDL24> <POSNR>000020</POSNR> <MATNR>0000000000000OTL</MATNR> <WERKS>C304</WERKS> <LGMNG>1</LGMNG> </E1EDL24> <E1EDL24> <POSNR>000030</POSNR> <MATNR>0000000000000DPB</MATNR> <WERKS>C304</WERKS> <LGMNG>1</LGMNG> </E1EDL24> </E1EDL20> </E1EDT20> </IDOC> </ZSHPMNT5>";
	    OutputStream output = new BufferedOutputStream(connection.getOutputStream());
	    output.write(body.getBytes());
	    output.flush();
				

		connection.connect();
		
		int responseCode = connection.getResponseCode();
		if (responseCode == 200) {
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println("response :: "+response.toString());
		}
		System.out.println(responseCode);
	}
	
	private static HostnameVerifier getHostNames() {
		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};
		return allHostsValid;
	}

	private static SSLContext getSSLContext() throws KeyStoreException, 
	NoSuchAlgorithmException, CertificateException, IOException, UnrecoverableKeyException, KeyManagementException {
		KeyStore ks = KeyStore.getInstance("PKCS12");
		FileInputStream fis = new FileInputStream(KEYSTORE_PATH);
		ks.load(fis, keyStorePass.toCharArray());

		KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
		kmf.init(ks, keyStorePass.toCharArray());

		SSLContext sc = SSLContext.getInstance("TLS");
		sc.init(kmf.getKeyManagers(), byPassSSL(), new java.security.SecureRandom());

		return sc;
	}

	private static TrustManager[] byPassSSL() {
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		} };
		
		return trustAllCerts;
	}
	
	private static String getBasicAuthrization() {
		String userpass = userId + ":" + password;
		return "Basic " + new String(Base64.getEncoder().encode(userpass.getBytes()));
	}

}
