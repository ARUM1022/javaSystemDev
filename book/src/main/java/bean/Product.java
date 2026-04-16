package bean;
//								↓必須
public class Product implements java.io.Serializable {
//	↓全て、そのSQLのテーブルに存在するカラム名に合わせる
//	フィールド（属性、メンバ変数）の定義
	private int id;
	private String name;
	private int price;
	//それぞれのフィールドのゲッターとセッターを記述する
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}

	public void setId(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPrice(int price) {
		this.price=price;
	}
}
