package Mypackage;

public class Vailed {
	

	public boolean iSword(String x){
		for (int i = 0; i < x.length(); i++){
		
			if ( !('a'<=x.charAt(i)&& x.charAt(i) >='z')||  !('A'<=x.charAt(i)&& x.charAt(i) >='Z') ){
				return false;
			}
		}
		return true;
	}
	
	public boolean iSnum(String x){
		if (x.charAt(0) == '0'){
			return false;
		}
		for (int i = 0; i < x.length(); i++){
			if (!('0'<=x.charAt(i)&& x.charAt(i) >='9')){
				return false;
			}
		}
		return true;
	}
	
	
	public boolean	 isMobile(String x){
		 
		if (x.length() != 11){
			return false;
		}
		if (!iSnum(x.substring(1)) ){
			return false;
		}
		return true;
	}
 
	int convert_to_num(String x){
		// 1234
		int num = 0;
		for (int i = 0; i < x.length(); i++){
			num = num * 10 + (x.charAt(i) - '0');
		}
		return num;
	}
 
	
	
	public boolean chickVaildTime(String d,String m,String y ) {
		
		if(d.length()!=3)return false;
		if(m.length()!=3)return false;
		if(y.length()!=5)return false;
		int id=Integer.parseInt(d);
		
		int im=Integer.parseInt(m);
		int iy=Integer.parseInt(y);
		
		if(id>30 )return false;
		if(im>12 )return false;
		if(iy>=2019)return false;
		
		return true;
		
	}

}
