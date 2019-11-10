package victor.training.jpa.app.common;


import java.util.Optional;

import static java.util.Optional.ofNullable;

public class GetCurrentUserUtil {

	public static Optional<String> getCurrentUserOpt() {
		return ofNullable(getCurrentUser());
	}
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
