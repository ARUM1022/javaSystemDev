package tool;
import org.eclipse.tags.shaded.org.apache.xpath.operations.String;

public class EncodingFilter{
//init
    private void init(Filterconfig filterconfig) throws Exception{
	    String encoding = new String();
		encoding = "UTF-8";
    }
//dofilter
    public void dofilter(ServletRequest request,ServletResponse response,FilterChain chain)throws Exception{
		request.setCharacterEncoding(encoding);
	    response.setCharacterEncoding(encoding);
	    chain.doFilter(request, response);
	}
//destroy
	public void destroy()throws Exception{
		
	}
}