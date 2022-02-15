package vn.vimass.service.mayTram;

import VimassLib.util.TBTT.object.ErrorCode;
import VimassLib.util.TBTT.object.ObjectMessageResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import vn.vimass.entities.User;
import vn.vimass.utils.VimassData;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;



@Path("/HoaDonDienTuFPT")
@Produces("application/json;charset=utf-8")
public class ServiceWebService2 {

	@GET
	@Path("/test")
	public String test()
	{
		return "ok";
	}

	@POST
	@Path("/testDangNhap")
	public String testDangNhap(String input) {

		VimassData.ghiLogRequest("QRServices : testDangNhap: " + input);

		Gson gson = new GsonBuilder()
			    .disableHtmlEscaping()
			    .create();

		ObjectMessageResult result = ErrorCode.getObjectMessageResult(
				ErrorCode.FALSE, ErrorCode.MES_FALSE);

		try
		{
			User user = gson.fromJson(input, User.class);
			if(user!=null)
			{
				if ((user.getUsername() == "") ||(user.getPassword() == "") )
				{
						result = ErrorCode.getObjectMessageResult(
						ErrorCode.PARAM_SATELESS, ErrorCode.MES_PARAM_SATELESS);
				}
					else {
						result = ErrorCode.getObjectMessageResult(
						ErrorCode.SUCCESS, ErrorCode.MES_SUCCESS);
						result.result = "ok";
				}
			}
			else {
				result = ErrorCode.getObjectMessageResult(
				ErrorCode.PARAM_SATELESS, ErrorCode.MES_PARAM_SATELESS);
			}
		}catch (Exception e) {
			// TODO: handle exception
			VimassData.ghiLogRequest("QRServices : testDangNhap : " +e.getMessage());

		}
		return "ok";
//		return gson.toJson(result);
	}
}
