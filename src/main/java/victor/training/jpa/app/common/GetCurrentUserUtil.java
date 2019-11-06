package victor.training.jpa.app.common;

public class GetCurrentUserUtil {

	public static String getCurrentUser() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (authentication==null) {
//			return "sys"; // at start-up, there is no user logged in
//		} else {
//			return authentication.getName();
//		}
		 return "user1"; // FIXME: hard-coded
	}
}
