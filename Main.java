package question;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

//import question.Client.CachedContent;

//import question.Client.CachedContent;

public class Main {

	public static void main(String[] args) {

//		DnsTree tree1 = new DnsTree();
//
//		tree1.getAllRecords();// ağaç boşken kayıt alma
//
//		tree1.insertRecord("boun.edu.tr", "1.1.1.1");// domain ekleme
//		System.out.println(tree1.getAllRecords());
//
//		tree1.insertRecord("boun.edu.tr", "1.1.1.1");// aynı domaini bir daha ekleme
//		System.out.println(tree1.getAllRecords());
//
//		tree1.insertRecord("registration.boun.edu.tr", "1.1.1.2");// var olan domainin üzerine parça ekleme
//		System.out.println(tree1.getAllRecords());
//
//		System.out.println(tree1.removeRecord("boun.edu.tr"));// çocuğu olan nodu silme
//		System.out.println(tree1.getAllRecords());
//
//		System.out.println(tree1.removeRecord("boun.edu.tr", "1.1.1.1"));// var olmayan bir ip adresini silme
//		System.out.println(tree1.getAllRecords());
//
//		System.out.println(tree1.removeRecord("registration.boun.edu.tr", "1.1.1.2"));// tek ip si olan ve çocuğu
//																						// olmayan domaini silme
//		System.out.println(tree1.getAllRecords());
//
//		tree1.insertRecord("wer.edu.tr", "7.7.7.7");// node ekleme
//		System.out.println(tree1.getAllRecords());
//
//		tree1.insertRecord("wer.edu.tr", "8.8.8.8");// var olan noda ip ekleme
//		System.out.println(tree1.getAllRecords());
//
//		System.out.println(tree1.queryDomain("wer.edu.tr"));// 2 id li domainde robin kontrolü
//		System.out.println(tree1.queryDomain("wer.edu.tr"));
//		System.out.println(tree1.queryDomain("wer.edu.tr"));
//
//		System.out.println(tree1.removeRecord("wer.edu.tr", "8.8.8.8"));// iki ip si olan domainden bir ip silme
//		System.out.println(tree1.getAllRecords());
//
//		tree1.insertRecord("online.wer.edu.tr", "7.7.8.8");// var olan domainin üzerine parça ekleme
//		System.out.println(tree1.getAllRecords());
//
//		System.out.println(tree1.removeRecord("wer.edu.tr", "7.7.7.7"));// tek ip si olan ve çocuğu olan nodun ip sini
//																		// silme
//		System.out.println(tree1.getAllRecords());
//
//		System.out.println(tree1.queryDomain("wer.edu.tr"));// ip si olmayan domainde robin kontrolü
//		System.out.println(tree1.getAllRecords());
//
//		System.out.println(tree1.removeRecord("boun.edu.tr", "1234"));// olmayan bir ip yi silme
//		System.out.println(tree1.getAllRecords());
//
//		Client koray = new Client("2.3.4.5", tree1);
//		Client baki = new Client("1.2.3.4", tree1);
//		Client müco = new Client("3.4.5.6", tree1);
//
//		tree1.insertRecord("wer.edu.tr", "5.5.5.5");// ip si olmayan node a id ekleme
//		System.out.println(tree1.getAllRecords());
//
//		tree1.insertRecord("wer.edu.tr", "9.9.9.9");// bir ip si olan node a id ekleme
//
//		System.out.println(koray.sendRequest("wer.edu.tr"));
//		System.out.println(baki.sendRequest("wer.edu.tr"));
//		System.out.println(koray.sendRequest("wer.edu.tr"));
//		System.out.println(müco.sendRequest("wer.edu.tr"));
//
//		tree1.insertRecord("edu.tr", "146555244478");// var olan noda ip ekleme
//		System.out.println(tree1.getAllRecords());
//
//		System.out.println(tree1.queryDomain("wer.edu.tr"));// robin kontrolü
//
//		System.out.println(tree1.removeRecord("edu.tr"));// çocuğu olan noddan ip silme
//		System.out.println(tree1.getAllRecords());
//
//		tree1.insertRecord("edevlet.org", "0.2.3.4.5.6");
//		tree1.insertRecord("edevlet1.org", "1.2.3.4.5.7");
//		tree1.insertRecord("edevlet2.org", "2.2.3.4.5.8");
//		tree1.insertRecord("edevlet3.org", "3.2.3.4.5.9");
//		tree1.insertRecord("edevlet4.org", "4.2.3.4.5.0");
//		tree1.insertRecord("edevlet5.org", "5.2.3.4.5.1");
//		tree1.insertRecord("edevlet6.org", "6.2.3.4.5.2");
//		tree1.insertRecord("edevlet7.org", "7.2.3.4.5.3");
//		tree1.insertRecord("edevlet8.org", "8.2.3.4.5.4");
//		tree1.insertRecord("edevlet9.org", "9.2.3.4.5.5");
//		tree1.insertRecord("edevlet10.org", "10.2.3.4.4.6");
//		tree1.insertRecord("edevlet11.org", "111.2.3.4.3.6");
//		tree1.insertRecord("edevlet12.org", "1.2.7.4.2.6");
//		tree1.insertRecord("edevlet13.org", "1.2.9.4.5.0");
//		tree1.insertRecord("edevlet.org", "1.2.11.4.5.0");
//		tree1.insertRecord("edevlet1.org", "1.2.1.4.5.0");
//		tree1.insertRecord("edevlet2.org", "1.2.2.4.5.0");
//		tree1.insertRecord("edevlet3.org", "1.2.0.4.5.0");
//
//		System.out.println(koray.sendRequest("edevlet.org"));
//		System.out.println(koray.sendRequest("edevlet.org"));
//
//		System.out.println(koray.sendRequest("edevlet1.org"));
//		System.out.println(koray.sendRequest("edevlet1.org"));
//		System.out.println(koray.sendRequest("edevlet2.org"));
//		System.out.println(koray.sendRequest("edevlet2.org"));
//		System.out.println(koray.sendRequest("edevlet2.org"));
//		System.out.println(koray.sendRequest("edevlet2.org"));
//		System.out.println(koray.sendRequest("edevlet7.org"));
//		System.out.println(koray.sendRequest("edevlet8.org"));
//		System.out.println(koray.sendRequest("edevlet9.org"));
//		System.out.println(koray.sendRequest("edevlet10.org"));
//		System.out.println(koray.sendRequest("edevlet11.org"));
//		System.out.println(koray.sendRequest("edevlet12.org"));
//		System.out.println(koray.sendRequest("edevlet13.org"));
//		System.out.println(koray.sendRequest("edevlet.org"));
//		System.out.println(koray.sendRequest("edevlet.org"));
//		System.out.println(koray.sendRequest("edevlet.org"));
//		System.out.println(koray.sendRequest("edevlet.org"));
//		System.out.println(koray.sendRequest("edevlet.org"));
//		System.out.println(koray.sendRequest("edevlet.org"));
//		System.out.println(koray.sendRequest("edevlet.org"));


		
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		
//		
//		
//		DnsTree tree1 = new DnsTree();
//		tree1.insertRecord("cambridge.ac.uk", "8.8.8.8");
//		tree1.insertRecord("cambridge.ac.uk", "8.456.8");
//		tree1.insertRecord("bbc.co.uk", "7.7.7.7");
//		tree1.insertRecord("google.com", "3.3.3.3");
//		tree1.insertRecord("mail.google.com", "4.4.4.4");
//		tree1.insertRecord("twitter.com", "5.5.5.5");
//		tree1.insertRecord("developer.twitter.com", "6.6.6.6");
//		tree1.insertRecord("boun.edu.tr", "1.1.1.1");
//		tree1.insertRecord("cmpe.boun.edu.tr", "2.2.2.2");
//		tree1.insertRecord("metu.edu.tr", "1.1.1.1");
//		tree1.insertRecord("cmpe.boun.edu.tr", "2.2.2");
//		tree1.insertRecord("boun.edu.tr", "2.245672");
//		tree1.insertRecord("this.metu.edu.tr", "2.2.2.2");
//		tree1.insertRecord("this.mwtu.edu.tr", "2.2.22");
//		tree1.insertRecord("co.uk", "111222333");
//		tree1.removeRecord("co.uk", "111222333");
//		tree1.insertRecord("my.twitter.com", "2112121212");
//		tree1.insertRecord("this.my.twitter.com", "243547");
//		Client koray = new Client("2005",tree1);
//		koray.sendRequest("cambridge.ac.uk");
//		koray.sendRequest("bbc.co.uk");
//		koray.sendRequest("google.com");
//		koray.sendRequest("mail.google.com");
//		koray.sendRequest("twitter.com");
//		koray.sendRequest("developer.twitter.com");
//		koray.sendRequest("boun.edu.tr");
//		koray.sendRequest("cmpe.boun.edu.tr");
//		koray.sendRequest("metu.edu.tr");
//		koray.sendRequest("this.metu.edu.tr");
//		koray.sendRequest("co.uk");
//		koray.sendRequest("this.metu.edu.tr");
//		koray.sendRequest("my.twitter.com");
//		koray.sendRequest("this.my.twitter.com");
//		System.out.println(koray.cacheList[9]);
//		tree1.removeRecord("boun.tr");
//		tree1.removeRecord("boun.edu.tr", "123");
//		tree1.insertRecord("metur.edu.tr.com", "133344");
//		tree1.insertRecord("com.tr.com", "3456789");
//		tree1.removeRecord(".tr.com");
//		tree1.removeRecord("com");
//		tree1.insertRecord("cmpe.boun.edu.tr", "2.24442");
//		tree1.insertRecord("cmpee.boun.edu.tr", "2.2.2");
//		koray.sendRequest("cmpee.boun.edu.tr");
//		System.out.println(tree1.queryDomain("cmpe.boun.edu.tr"));
//		System.out.println(tree1.queryDomain("cmpe.boun.edu.tr"));
//		System.out.println(tree1.queryDomain("cmpe.boun.edu.tr"));
//		System.out.println(tree1.getAllRecords());
//		
//
//		
//		System.out.println();
//		System.out.println();
//		System.out.println();
		

		
		
//		DnsTree tree = new DnsTree();
//
//		tree.insertRecord("google.com", "3.3.3.3");
//		tree.insertRecord("boun.edu.tr", "1.1.1.1");
//		tree.insertRecord("cmpe.boun.edu.tr", "2.2.2.2");
//		tree.insertRecord("metu.edu.tr", "9.9.9.9");
//		tree.insertRecord("twitter.com", "5.5.5.5");
//		tree.insertRecord("developer.twitter.com", "6.6.6.6");
//		tree.insertRecord("mail.google.com", "4.4.4.4");
//		tree.insertRecord("bbc.co.uk", "7.7.7.7");
//		tree.insertRecord("cambridge.ac.uk", "8.8.8.8");
//		tree.insertRecord("z.cambridge.ac.uk", "0.0.0.0");
//		tree.insertRecord("google.com", "10.10.10.10");
//		tree.insertRecord("google.com", "11.10.10.10");
//		tree.insertRecord("google.com", "12.10.10.10");
//		tree.insertRecord("google.com", "13.10.10.10");
//		tree.insertRecord("google.com", "14.10.10.10");
//		tree.insertRecord("google.com", "15.10.10.10");
//
//		for (String s : tree.getAllRecords().keySet()) {
//			System.out.print(s + " ");
//			for (String r : tree.getAllRecords().get(s)) {
//				System.out.print(r + " ");
//			}
//			System.out.println();
//		}
//
//		System.out.println();
//
//		System.out.println(tree.queryDomain("google.com"));
//		System.out.println(tree.queryDomain("google.com"));
//		System.out.println(tree.queryDomain("google.com"));
//		System.out.println(tree.queryDomain("google.com"));
//		System.out.println(tree.queryDomain("google.com"));
//		System.out.println(tree.queryDomain("google.com"));
//		System.out.println(tree.queryDomain("google.com"));
//		System.out.println(tree.queryDomain("google.com"));
//		System.out.println(tree.queryDomain("google.com"));
//		System.out.println(tree.queryDomain("google.com"));
//		System.out.println(tree.queryDomain("google.com"));
//		System.out.println(tree.queryDomain("google.com"));
//		System.out.println(tree.queryDomain("google.com"));
//		Client eleman = new Client("100.100.100.100", tree);
//
//		System.out.println("<------------------------------------------>");
//
//		for (String s : tree.getAllRecords().keySet()) {
//			eleman.addToCache(s, tree.queryDomain(s));
//			eleman.sendRequest(s);
//			eleman.sendRequest(s);
//			eleman.sendRequest(s);
//		}
//
//		eleman.sendRequest("bbc.co.uk");
//		for (CachedContent s : eleman.getCacheList()) {
//			if (s != null) {
//				System.out.println(s.getDomainName() + " " + s.getHitNo());
//			}
//		}
//		System.out.println();
//		tree.insertRecord("deneme.com", "45.45.32.21");
//		eleman.sendRequest("deneme.com");
//		eleman.sendRequest("deneme.com");
//		eleman.sendRequest("deneme.com");
//		eleman.sendRequest("deneme.com");
//		for (CachedContent s : eleman.getCacheList()) {
//			if (s != null) {
//				System.out.println(s.getDomainName() + " " + s.getHitNo());
//			}
//		}
//		System.out.println();
//		tree.insertRecord("aaaa.com", "45.45.32.22");
//		eleman.sendRequest("aaaa.com");
//		for (CachedContent s : eleman.getCacheList()) {
//			if (s != null) {
//				System.out.println(s.getDomainName() + " " + s.getHitNo());
//			}
//		}
//
//		System.out.println(tree.root.childNodeList.keySet());
//
//		for (DnsNode a : tree.root.childNodeList.values()) {
//
//			System.out.println(a.childNodeList.keySet());
//
//		}
//	}
		
		

//		        DnsTree tree = new DnsTree();
//		        Client c = new Client("192.168.1.1", tree);
//
//		        tree.insertRecord("bbc.co.uk", "7.7.7.7");
//		        tree.insertRecord("cambridge.ac.uk", "8.8.8.8");
//		        tree.insertRecord("google.com", "3.3.3.3");
//		        tree.insertRecord("mail.google.com", "4.4.4.4");
//		        tree.insertRecord("twitter.com", "5.5.5.5");
//		        tree.insertRecord("developer.twitter.com", "6.6.6.6");
//		        tree.insertRecord("boun.edu.tr", "1.1.1.1");
//		        tree.insertRecord("cmpe.boun.edu.tr", "2.2.2.1");
//		        tree.insertRecord("cmpe.boun.edu.tr", "2.2.2.2");
//		        tree.insertRecord("metu.edu.tr", "1.1.1.1");
//		        tree.insertRecord("google.com", "4.4.4.4");
//		        tree.insertRecord("google.com", "5.5.5.5");
//		        tree.insertRecord("machine.boun.edu.tr", "19.9.9.9");
//		        tree.insertRecord("machine.boun.edu.tr", "19.9.9.8");
//		        tree.insertRecord("facebook.com", "10.10.10.10");
//		        tree.insertRecord("facebook.com", "10.10.10.11");
//		        assertTrue(!tree.removeRecord("abc", "4.4.4.4"));
//		        assertTrue(!tree.removeRecord("com"));
//
//		        assertEquals(tree.queryDomain("google.com"), "3.3.3.3");
//		        assertEquals(tree.queryDomain("google.com"), "4.4.4.4");
//
//		        assertTrue(tree.removeRecord("google.com", "4.4.4.4"));
//
//		        assertEquals(tree.queryDomain("google.com"), "5.5.5.5");
//		        assertEquals(tree.queryDomain("google.com"), "3.3.3.3");
//
//		        String[][] testDomains = {
//		                {"google.com", "5.5.5.5"}, {"google.com", "5.5.5.5"},
//		                {"boun.edu.tr", "1.1.1.1"}, {"boun.edu.tr", "1.1.1.1"},
//		                {"cmpe.boun.edu.tr", "2.2.2.1"},
//		                {"metu.edu.tr", "1.1.1.1"}, {"metu.edu.tr", "1.1.1.1"},
//		                {"twitter.com", "5.5.5.5"}, {"twitter.com", "5.5.5.5"},
//		                {"bbc.co.uk", "7.7.7.7"}, {"bbc.co.uk", "7.7.7.7"},
//		                {"cambridge.ac.uk", "8.8.8.8"}, {"cambridge.ac.uk", "8.8.8.8"},
//		                {"mail.google.com", "4.4.4.4"}, {"mail.google.com", "4.4.4.4"},
//		                {"developer.twitter.com", "6.6.6.6"}, {"developer.twitter.com", "6.6.6.6"},
//		                {"machine.boun.edu.tr", "19.9.9.9"}, {"machine.boun.edu.tr", "19.9.9.9"},
//		                {"facebook.com", "10.10.10.10"},
//		                {"cmpe.boun.edu.tr", "2.2.2.2"},
//		                {"facebook.com", "10.10.10.11"},
//		                {"machine.boun.edu.tr", "19.9.9.9"},
//		                {"f.com", null}
//		        };
//		        for (String[] testDomain : testDomains) {
//		            assertEquals(c.sendRequest(testDomain[0]), testDomain[1]);
//		        }
//
//		        String expectedRecords = "twitter.com:[5.5.5.5]\n" +
//		                "google.com:[3.3.3.3, 5.5.5.5]\n" +
//		                "boun.edu.tr:[1.1.1.1]\n" +
//		                "developer.twitter.com:[6.6.6.6]\n" +
//		                "facebook.com:[10.10.10.10, 10.10.10.11]\n" +
//		                "mail.google.com:[4.4.4.4]\n" +
//		                "cmpe.boun.edu.tr:[2.2.2.1, 2.2.2.2]\n" +
//		                "cambridge.ac.uk:[8.8.8.8]\n" +
//		                "bbc.co.uk:[7.7.7.7]\n" +
//		                "machine.boun.edu.tr:[19.9.9.8, 19.9.9.9]\n" +
//		                "metu.edu.tr:[1.1.1.1]\n";
//		        StringBuilder realRecords = new StringBuilder();
//		        for (Map.Entry<String, Set<String>> entry : tree.getAllRecords().entrySet()) {
//		            realRecords.append(entry.getKey()).append(":").append(entry.getValue()).append('\n');
//		        }
//
//		        assertEquals(realRecords.toString(), expectedRecords);
//		    }
//
//		    public static void assertTrue(boolean b) {
//		        if (!b) {
//		            throw new RuntimeException("failed assertion");
//		        }
//		    }
//
//		    public static <K> void assertEquals(K k1, K k2) {
//		        if (!Objects.equals(k1, k2)) {
//		            throw new RuntimeException("failed assertion, " + k1 + "!=" + k2);
//		        }
//		    }
	
	
	
	
//	DnsTree tree = new DnsTree();
//	Client cl1 = new Client("9.1.1.1", tree);
//	Client cl2 = new Client("9.1.1.2", tree);
//	Client cl3 = new Client("9.1.1.3", tree);
//	
//	tree.insertRecord("boun.edu.tr", "1.1.1.1");
//	
//	tree.insertRecord("boun.edu.tr", "1.1.1.1");
//	tree.insertRecord("boun.edu.tr", "1.1.1.2");
//	tree.insertRecord("cmpe.boun.edu.tr", "2.2.2.2");
//	tree.insertRecord("metu.edu.tr", "1.1.1.1");
//	tree.insertRecord("google.com", "3.3.3.1");
//	tree.insertRecord("google.com", "3.3.3.2");
//	tree.insertRecord("google.com", "3.3.3.3");
//	tree.insertRecord("google.com", "3.3.3.4");
//	tree.insertRecord("mail.google.com", "4.4.4.1");
//	tree.insertRecord("twitter.com", "5.5.5.5");
//	tree.insertRecord("developer.twitter.com", "6.6.6.6");
//	tree.insertRecord("bbc.co.uk", "7.7.7.7");
//	tree.insertRecord("cambridge.ac.uk", "8.8.8.8");
//	tree.insertRecord("drive.google.com", "4.4.4.2");
//	tree.insertRecord("images.google.com", "4.4.4.3");
//	tree.insertRecord("documentary.bbc.co.uk", "9.9.9.1");
//	tree.insertRecord("documentary.bbc.co.uk", "9.9.9.2");
//	tree.insertRecord("med.hacettepe.edu.tr", "11.11.11.11");
//	tree.insertRecord("med.hacettepe.edu.tr", "11.11.11.12");
//	tree.insertRecord("discord.com", "13.13.13.13");
//	tree.insertRecord("download.discord.com", "14.14.14.1");
//	tree.insertRecord("nitro.discord.com", "14.14.14.2");
//	tree.insertRecord("eu.en.download.discord.com", "15.15.15.15");
//	
//	TreePrinterGoBrrr.printTree(tree);
//	
//	System.out.println("\n######################################################\n");
//	
//	System.out.println("All records before removal: ");
//	System.out.println();
//	System.out.println(tree.getAllRecords());
//	
//	System.out.println("\n######################################################\n");
//	
//	System.out.println("Nonexistent node removed: " + tree.removeRecord("cerrahpasa.edu.tr"));
//	System.out.println("IP of nonexistant node removed: " + tree.removeRecord("cerrahpasa.edu.tr", "12.12.12.12"));
//	System.out.println();
//	System.out.println("Nonexistent IP of valid leaf node removed: " + tree.removeRecord("documentary.bbc.co.uk", "0.0.0.0"));
//	System.out.println("Existing IP of valid leaf node removed: " + tree.removeRecord("documentary.bbc.co.uk", "9.9.9.2"));
//	System.out.println("Last IP of valid leaf node removed: " + tree.removeRecord("documentary.bbc.co.uk", "9.9.9.1"));
//	System.out.println("Valid leaf node removed: " + tree.removeRecord("eu.en.download.discord.com"));
//	System.out.println();
//	System.out.println("Nonexistent IP of valid intermediate node removed: " + tree.removeRecord("boun.edu.tr", "0.0.0.0"));
//	System.out.println("Existing IP of valid intermediate node removed: " + tree.removeRecord("boun.edu.tr", "1.1.1.2"));
//	System.out.println("Last IP of valid intermediate node removed: " + tree.removeRecord("boun.edu.tr", "1.1.1.1"));
//	System.out.println("Valid intermediate node removed: " + tree.removeRecord("twitter.com"));
//	System.out.println();
//	System.out.println("Nonexistent IP of non-valid leaf node removed: " + tree.removeRecord("en.download.discord.com", "0.0.0.0"));
//	System.out.println("Non-valid leaf node removed: " + tree.removeRecord("en.download.discord.com"));
//
//	System.out.println("Nonexistent IP of non-valid intermediate node removed: " + tree.removeRecord("edu.tr", "0.0.0.0"));
//	System.out.println("Non-valid intermediate node removed: " + tree.removeRecord("hacettepe.edu.tr"));
//	
//	System.out.println("\n######################################################\n");;
//	
//	TreePrinterGoBrrr.printTree(tree);
//	
//	System.out.println("\n######################################################\n");
//	
//	System.out.println("All records after removal: ");
//	System.out.println();
//	System.out.println(tree.getAllRecords());
//	
//	System.out.println("\n######################################################\n");	
//	
//	System.out.println("First loop:");
//	
//	System.out.println();
//	
//	System.out.println(tree.queryDomain("google.com"));
//	System.out.println(tree.queryDomain("google.com"));
//	System.out.println(tree.queryDomain("google.com"));
//	System.out.println(tree.queryDomain("google.com"));
//	
//	System.out.println();
//	System.out.println("Second loop with insertion:");
//	System.out.println();
//	
//	System.out.println(tree.queryDomain("google.com"));
//	System.out.println(tree.queryDomain("google.com"));
//
//	tree.insertRecord("google.com", "3.3.3.5");
//	
//	System.out.println(tree.queryDomain("google.com"));
//	System.out.println(tree.queryDomain("google.com"));
//	
//	System.out.println();
//	System.out.println("Third loop with inserted IP:");
//	System.out.println();
//	
//	System.out.println(tree.queryDomain("google.com"));
//	System.out.println(tree.queryDomain("google.com"));
//	System.out.println(tree.queryDomain("google.com"));
//	System.out.println(tree.queryDomain("google.com"));
//	System.out.println(tree.queryDomain("google.com"));
//	
//	System.out.println();
//	System.out.println("Fourth loop with removal:");
//	System.out.println();
//	
//	System.out.println(tree.queryDomain("google.com"));
//	System.out.println(tree.queryDomain("google.com"));
//	System.out.println(tree.queryDomain("google.com"));
//	tree.removeRecord("google.com", "3.3.3.5");
//	System.out.println(tree.queryDomain("google.com"));
//	System.out.println(tree.queryDomain("google.com"));
//
//	System.out.println();
//	System.out.println("Fifth loop without removed IP:");
//	System.out.println();
//	
//	System.out.println(tree.queryDomain("google.com"));
//	System.out.println(tree.queryDomain("google.com"));
//	System.out.println(tree.queryDomain("google.com"));
//	System.out.println(tree.queryDomain("google.com"));
//	
//	System.out.println("\n######################################################\n");
//	
//	System.out.println("Query nonexistent domain: " + tree.queryDomain("edu.tr"));
//	
//	System.out.println("\n######################################################\n");
//	
//	System.out.println("First state of cache:");
//	
//	cl1.sendRequest("instagram.com");
//	
//	cl1.sendRequest("discord.com");
//	cl1.sendRequest("cmpe.boun.edu.tr");
//	cl1.sendRequest("metu.edu.tr");
//	cl1.sendRequest("google.com");
//	cl1.sendRequest("mail.google.com");
//	cl1.sendRequest("nitro.discord.com");
//	cl1.sendRequest("developer.twitter.com");
//	cl1.sendRequest("bbc.co.uk");
//	cl1.sendRequest("cambridge.ac.uk");
//	cl1.sendRequest("med.hacettepe.edu.tr");
//	
//	printCache(cl1);
//	
//	System.out.println("Requesting a domain with more than one IP: ");
//	System.out.println();
//	System.out.println(cl1.sendRequest("google.com"));
//	System.out.println(cl1.sendRequest("google.com"));
//	System.out.println(cl1.sendRequest("google.com"));
//	
//	System.out.println();
//	
//	System.out.println("Second state of cache:");
//	
//	cl1.sendRequest("discord.com");
//	cl1.sendRequest("cmpe.boun.edu.tr");
//	cl1.sendRequest("metu.edu.tr");
//	cl1.sendRequest("google.com");
//	cl1.sendRequest("mail.google.com");
//	cl1.sendRequest("nitro.discord.com");
//	cl1.sendRequest("developer.twitter.com");
//	cl1.sendRequest("bbc.co.uk");
//	cl1.sendRequest("cambridge.ac.uk");
//	cl1.sendRequest("med.hacettepe.edu.tr");
//	
//	cl1.sendRequest("discord.com");
//	cl1.sendRequest("cmpe.boun.edu.tr");
//	cl1.sendRequest("metu.edu.tr");
//	cl1.sendRequest("google.com");
//	cl1.sendRequest("mail.google.com");
//	cl1.sendRequest("nitro.discord.com");
//	cl1.sendRequest("developer.twitter.com");
//	cl1.sendRequest("bbc.co.uk");
//	cl1.sendRequest("cambridge.ac.uk");
//	
//	printCache(cl1);
//	
//	System.out.println("Replacing least used domain with: " + cl1.sendRequest("images.google.com"));
//	
//	printCache(cl1);
//	
//	System.out.println("######################################################\n");
//	
//	cl2.sendRequest("google.com");
//	cl3.sendRequest("google.com");
//	
//	System.out.println("Query sequence after client requests:\n");
//	
//	System.out.println(tree.queryDomain("google.com"));
//	
//	System.out.println();
//	
//	System.out.println(tree.queryDomain("google.com"));
//	System.out.println(tree.queryDomain("google.com"));
//	System.out.println(tree.queryDomain("google.com"));
//	System.out.println(tree.queryDomain("google.com"));
//
//
//}
//
//public static void printCache(Client client) {
//	
//	System.out.println();
//	
//	for(int i = 0; i<10; i++) {
//		if(client.cacheList[i] != null) {
//			System.out.println(client.cacheList[i].getDomainName() + " = " + client.cacheList[i].getIpAddress() + " | Hit No: " + client.cacheList[i].getHitNo());
//		} else {
//			System.out.println("null");
//		}
//		
//	}
//	
//	System.out.println();
//	
//}
	
	
	


	}	
}
