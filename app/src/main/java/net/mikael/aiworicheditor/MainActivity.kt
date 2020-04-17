package net.mikael.aiworicheditor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
val OLD_HTML="<p style=\"margin: 24px 0px; line-height: 26px; font-size: 17px; word-break: break-all; text-align: justify;\">There are more than 3.5 billion people who use smartphones, but that’s only 45 percent of the world’s population. We created Android (Go edition) to bring more affordable, high-quality smartphones to people around the world. Thanks to our partners who have made more than 1,600 device models available in 180+ countries, there are now more than 100 million active Android (Go edition) devices around the world. Here are some updates on Go edition’s progress and where we’re going next.</p><p style=\"margin: 24px 0px; line-height: 26px; font-size: 17px; word-break: break-all; text-align: justify;\">&nbsp;<span style=\"font-weight: bold;\">Powering universal access to information</span></p><p style=\"margin: 24px 0px; line-height: 26px; font-size: 17px; word-break: break-all; text-align: justify;\">In partnership with Safaricom, Kenya’s largest telecom provider, we brought more than 900,000 Android (Go edition) smartphones to people in Kenya—53 percent of whom were women—through their “Life is Digital” campaign. This is especially important because there is a significant gender gap in mobile internet usage in Sub-Saharan Africa.&nbsp;</p><div contenteditable=\"false\" class=\"img_container\"><img src=\"https://aiwo-img.oss-cn-hangzhou.aliyuncs.com/72220515.jpg\" alt=\"\"></div><p style=\"margin: 24px 0px; line-height: 26px; font-size: 17px; word-break: break-all; text-align: justify;\">Maisha Ni Digital_Mkulima 8.45x15.95.png\n" +
        "With the help of the suite of Google apps designed for Go edition, people are connecting with new   opportunities and making gains in their daily lives. For example, Google Go has helped connect millions of people to information by providing a lightweight search engine that works on unstable connections. And with Lens in Google Go, people can quickly translate, hear and search text they see in the real world using their phone camera—helping them understand words on street signs, medicine labels, documents, and more.&nbsp;</p><div contenteditable=\"false\" class=\"img_container\"><img src=\"https://aiwo-img.oss-cn-hangzhou.aliyuncs.com/25698798.jpg\" alt=\"\"></div><p style=\"margin: 24px 0px; line-height: 26px; font-size: 17px; word-break: break-all; text-align: justify;\">&nbsp;Across the Google apps designed for Android (Go edition), we’ve introduced a number of user privacy features to protect the next billion people coming online for the first time. For example, a new mode within Google Go lets people search without their searches being saved to their account, and Gallery Go leverages on-device machine learning to help people organize photos without ever sending data to the cloud.</p><p style=\"margin: 24px 0px; line-height: 26px; font-size: 17px; word-break: break-all; text-align: justify;\">&nbsp;<span style=\"font-weight: bold;\">Bringing a beautiful, fast camera experience to affordable devices</span>&nbsp;</p><p style=\"margin: 24px 0px; line-height: 26px; font-size: 17px; word-break: break-all; text-align: justify;\">Your phone’s camera gives you the power to capture memories that you’ll want to share with those around you. But on many smartphones, camera apps are often slow or complex to use, and your phone can quickly run out of storage.</p><div contenteditable=\"false\" class=\"img_container\"><img src=\"https://aiwo-img.oss-cn-hangzhou.aliyuncs.com/10471534.jpg\" alt=\"\"></div><p style=\"margin: 24px 0px; line-height: 26px; font-size: 17px; word-break: break-all; text-align: justify;\">&nbsp;Camera_Go_inline_V2.jpg\n" +
        "The new Camera Go app from Google helps you take beautiful photos without worrying about speed or storage. It has features like Portrait Mode to give your photos a professional look by focusing on your subject. It’s built for people using smartphones for the first time, so it has a clean and simple interface. And, most importantly, Camera Go tracks how much photo and video storage space you have left, and then it helps you clear up space so you never miss a shot.&nbsp;</p><p style=\"margin: 24px 0px; line-height: 26px; font-size: 17px; word-break: break-all; text-align: justify;\">&nbsp;Camera Go will be available on Nokia 1.3 and more Android (Go edition) devices soon.</p>"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        oldHtmlTv.setOnClickListener {
            val intent = Intent(this, EditorActivity::class.java)
            intent.putExtra("oldTitle", "Bringing more people online and introducing Camera Go")
            intent.putExtra("oldContent", OLD_HTML)
            startActivity(intent)
        }
        emptyHtmlTv.setOnClickListener {
            val intent = Intent(this, EditorActivity::class.java)
            startActivity(intent)
        }
    }
}
