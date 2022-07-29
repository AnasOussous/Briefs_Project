package entities;

public class CurrentAdmin {
	private static int currentAdminId;
	private static int id;
	

	public static int getCurrentUserId() {
		return currentAdminId;
	}

	public static void setCurrentUserId(int id) {
		currentAdminId = id;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int idEdit) {
		id = idEdit;
	}
}
