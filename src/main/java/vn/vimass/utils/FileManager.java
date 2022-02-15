package vn.vimass.utils;

import org.apache.commons.io.filefilter.WildcardFileFilter;

import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class FileManager {

	// Đọc File
	public static String readFile(String path) {
		String text = "";
		int read, N = 1024 * 1024;
		char[] buffer = new char[N];

		try {
			File f = new File(path);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			while (true) {
				read = br.read(buffer, 0, N);
				text += new String(buffer, 0, read);

				if (read < N) {
					break;
				}
			}
			br.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return text;
	}

	// Ghi File
	public static void writeFile(String path, String content, boolean append) {
		BufferedWriter writer = null;
		try {
			File f = new File(path);
//			writer = new BufferedWriter(new FileWriter(f, append));
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, append), "UTF-8"));
			writer.write(content);
		} catch (Exception e) {

		} finally {
			try {
				writer.close();
			} catch (Exception e) {
			}
		}

	}

	// Chuyển tệp thành dữ liệu nhị phân
	public static byte[] getBinaryDataFromFile(String path) {
		File file = new File(path);
		FileInputStream fin = null;
		byte fileContent[] = null;
		try {
			fin = new FileInputStream(file);
			fileContent = new byte[(int) file.length()];
			fin.read(fileContent);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fin != null) {
					fin.close();
				}
			} catch (IOException ioe) {
				System.out.println("Error while closing stream: " + ioe);
			}
		}
		return fileContent;
	}

	//  Xoá toàn bộ File trong Thư mục
	public static void xoaToanBoFileCuaThuMuc(String input) {
		try
		{
			VimassData.ghiLogRequest("xoaToanBoFileCuaThuMuc " + input);
			File dir = new File(input);
			FileFilter fileFilter = new WildcardFileFilter("*");
			File[] files = dir.listFiles(fileFilter);
			for(int i = 0; i < files.length; i++)
			{
				try
				{
					files[i].delete();
				}
				catch(Exception e)
				{

				}
			}
		}
		catch(Exception e)
		{

		}
	}

	// Kiểm tra số lượng File trong Thư mục
	public static int getTotalFileInFolder(String input) {
		try
		{
			File dir = new File(input);
			FileFilter fileFilter = new WildcardFileFilter("*.*");
			File[] files = dir.listFiles(fileFilter);
			return files.length;
		}
		catch(Exception e)
		{

		}
		return 0;
	}

	// Kiểm tra sự tồn tại
	public static boolean checkFileExist(String input) {
		try
		{
			File f = new File(input);
			if(f.exists())
			{
				return true;
			}
		}
		catch(Exception e)
		{

		}
		return false;
	}

	// Bỏ dấu tiếng Việt
	public static String boDauTiengViet(String sDuLieu) {
		if (sDuLieu != null) {
			sDuLieu = sDuLieu
					.replaceAll(
							"á|à|ả|ã|ạ|ă|ắ|ằ|ẳ|ẵ|ặ|â|ấ|ầ|ẩ|ẫ|ậ|Á|À|Ả|Ã|Ạ|Ă|Ắ|Ằ|Ẳ|Ẵ|Ặ|Â|Ấ|Ầ|Ẩ|Ẫ|Ậ",
							"a");
			sDuLieu = sDuLieu.replaceAll("đ|Đ", "d");
			sDuLieu = sDuLieu.replaceAll(
					"é|è|ẻ|ẽ|ẹ|ê|ế|ề|ể|ễ|ệ|É|È|Ẻ|Ẽ|Ẹ|Ê|Ế|Ề|Ể|Ễ|Ệ", "e");
			sDuLieu = sDuLieu.replaceAll("í|ì|ỉ|ĩ|ị|Í|Ì|Ỉ|Ĩ|Ị", "i");
			sDuLieu = sDuLieu
					.replaceAll(
							"ó|ò|ỏ|õ|ọ|ô|ố|ồ|ổ|ỗ|ộ|ơ|ớ|ờ|ở|ỡ|ợ|Ó|Ò|Ỏ|Õ|Ọ|Ô|Ố|Ồ|Ổ|Ỗ|Ộ|Ơ|Ớ|Ờ|Ở|Ỡ|Ợ",
							"o");
			sDuLieu = sDuLieu.replaceAll(
					"ú|ù|ủ|ũ|ụ|ư|ứ|ừ|ử|ữ|ự|Ú|Ù|Ủ|Ũ|Ụ|Ư|Ứ|Ừ|Ử|Ữ|Ự", "u");
			sDuLieu = sDuLieu.replaceAll("ý|ỳ|ỷ|ỹ|ỵ|Ý|Ỳ|Ỷ|Ỹ|Ỵ", "y");
		}

		return sDuLieu;
	}

	// Xoá file
	public static void xoaFile(String input) {
		try
		{
			File file = new File(input);
			file.delete();
		}
		catch(Exception e)
		{

		}
	}

	// Chuyển đổi chuỗi URL có khoảng trắng qua kí tự % (Cái kí tự đặc biệt khác nữa)
	public static String enCodeURL(String input)
	{
		try
		{
			return URLEncoder.encode(input, "utf-8");
		}
		catch(Exception e)
		{

		}
		return input;
	}

	// Chuyển đổi chuỗi URL kí tự % qua có khoảng trắng(Cái kí tự đặc biệt khác nữa)
	public static String deCodeURL(String input)
	{
		try
		{
			return URLDecoder.decode(input, "utf-8");
		}
		catch(Exception e)
		{

		}
		return input;
	}

}
