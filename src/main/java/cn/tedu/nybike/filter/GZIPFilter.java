package cn.tedu.nybike.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.WriteListener;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

@WebFilter(filterName = "gzipFilter", urlPatterns = "/realtimeData/*")
public class GZIPFilter implements Filter {
	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        MyResponse myResponse = new MyResponse(response);
        chain.doFilter(request, myResponse); // 不能直接放行，应增强response的getOutputStream()方法和response的getWriter()方法再放行

        // 取出缓冲中的数据压缩后输出
        byte[] out = myResponse.getBuffer(); // 得到目标资源的输出
        System.out.println("压之前：" + out.length);

        byte[] gzipout = gzip(out);
        System.out.println("压之后：" + gzipout.length);

        response.setHeader("Content-Encoding", "gzip");
        response.setHeader("Content-Length", gzipout.length+"");
        response.getOutputStream().write(gzipout);
		
	}

    // 压缩数据
    public byte[] gzip(byte[] b) throws IOException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        GZIPOutputStream gout = new GZIPOutputStream(bout);
        gout.write(b);
        gout.close();
        return bout.toByteArray();
    }

    // 内部类
    class MyResponse extends HttpServletResponseWrapper {
        private ByteArrayOutputStream bout = new ByteArrayOutputStream(); // 缓冲流，用字节数组作为缓冲
        private PrintWriter pw;

        private HttpServletResponse response;
        public MyResponse(HttpServletResponse response) {
            super(response);
            this.response = response;
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            return new MyServletOutputStream(bout);
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            pw = new PrintWriter(new OutputStreamWriter(bout, response.getCharacterEncoding())); // response.getCharacterEncoding()返回的是"UTF-8"
            return pw;
        }

        // 得到底层流中的数据
        public byte[] getBuffer() {
            if (pw != null) {
                pw.close();
            }
            return bout.toByteArray();
        }
    }

    class MyServletOutputStream extends ServletOutputStream {
        private ByteArrayOutputStream bout;
        public MyServletOutputStream(ByteArrayOutputStream bout) {
            this.bout = bout;
        }
        @Override
        public void write(int b) throws IOException {
            bout.write(b);
        }
		@Override
		public boolean isReady() {
			return false;
		}
		@Override
		public void setWriteListener(WriteListener listener) {
		}
    }
    
	public void init(FilterConfig arg0) throws ServletException {}

	public void destroy() {}
	
}
