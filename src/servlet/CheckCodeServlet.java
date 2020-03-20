package servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@WebServlet(name = "CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    // 验证码的宽度
    private static int WIDTH = 90;
    // 验证码的高度
    private static int HEIGHT = 36;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 获得session对象
        HttpSession session = request.getSession();
        // 设置编码
        response.setContentType("image/jpeg");
        // 获取输出流
        ServletOutputStream sos = response.getOutputStream();
        // 设置浏览器不要还缓存照片
        response.setHeader("Pargma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        // 创建内存图像，并获得图像的内容
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();
        // 产生随机的认证码
        char [] rands = generateCheckCode();
        // 产生图像
        drawBackGround(g);
        drawRands(g, rands);
        // 结束对象的绘制
        g.dispose();
        // 将对象输出到客户端
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "JPEG", bos);
        byte [] buf = bos.toByteArray();
        response.setContentLength(buf.length);
        sos.write(buf);
        bos.close();
        sos.close();
        // 将验证码存入 session，用于验证码的验证
        session.setAttribute("check_code", new String(rands));
    }

    /**
     * 从数字和小写字母中随机生成一个长度为4的字符数组
     * @return 长度为4的字符数组
     */
    private char [] generateCheckCode() {
        String chars = "0123456789abcdefghijklmnwpqrstuvwxyz";
        char [] rands = new char[4];
        for(int i=0; i<4; i++) {
            int rand = (int) (Math.random()*36);
            rands[i] = chars.charAt(rand);
        }
        return rands;
    }

    /**
     * 生成没有干扰的的验证图片
     * @param g
     * @param rands
     */
    private void drawRands(Graphics g, char [] rands) {
        g.setColor(Color.BLACK);
        g.setFont(new Font(null, Font.ITALIC|Font.BOLD, 24));

        g.drawString("" + rands[0], 1, 27);
        g.drawString("" + rands[1], 23, 25);
        g.drawString("" + rands[2], 45, 28);
        g.drawString("" + rands[3], 68, 26);

        System.out.println(rands);
    }

    /**
     * 生成有干扰的的验证图片
     * @param g
     */
    private void drawBackGround(Graphics g) {
        // 画背景图
        g.setColor(new Color(0xDCDCDC));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        // 产生干扰点
        for(int i=0; i<120; i++) {
            int x = (int) (Math.random() * WIDTH);
            int y = (int) (Math.random() * HEIGHT);
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            g.setColor(new Color(red, green, blue));
            g.drawOval(x, y, 1, 0);
        }
    }
}
