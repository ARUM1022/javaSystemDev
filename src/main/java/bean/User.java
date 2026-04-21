package bean;
 
public class User{
	
	/**
	 * 認証済みフラグ:boolean true:認証済み
	 */
	public boolean isAuthenticated;
	
	/**
	 * ゲッター、セッター
	 */
	public boolean isAutentivated() {
		return isAuthenticated;
	}
	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}
}