package rentcar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookId;
private int carid;
private String username;
private String sdate;
private String edate;


public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public int getCarid() {
	return carid;
}
public void setCarid(int carid) {
	this.carid = carid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getSdate() {
	return sdate;
}
public void setSdate(String sdate) {
	this.sdate = sdate;
}
public String getEdate() {
	return edate;
}
public void setEdate(String edate) {
	this.edate = edate;
}
public Booking(int carid, String username, String sdate, String edate) {
	
	
	this.carid = carid;
	this.username = username;
	this.sdate = sdate;
	this.edate = edate;
}
public Booking() {
	
}
@Override
public String toString() {
	return "Booking [bookId=" + bookId + ", carid=" + carid + ", username=" + username + ", sdate=" + sdate + ", edate="
			+ edate + "]";
}

	
}