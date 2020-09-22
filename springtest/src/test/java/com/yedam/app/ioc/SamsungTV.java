package com.yedam.app.ioc;

//@Component
public class SamsungTV implements TV {
	 //주입 factory.getBean("speaker")
	//@Resource(name = "appleSpeaker")
	//@Autowired 
	//@Qualifier("SonySpeaker")
	private Speaker speaker;	
	private int price;
	
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	//생성자 방식으로 의존관계 객체 주입
	public SamsungTV(Speaker speaker, int price) {
		this.speaker = speaker;
		this.price = price;
	}
	public SamsungTV() {}
	
	public void initMethod() {
		System.out.println("SamsungTV 초기화");
	}
	@Override
	public void powerOn() {
		System.out.println("SamsungTV powerOn :"  );
	}
	@Override
	public void powerOff() {
		System.out.println("SamsungTV powerDown");
	}
	@Override
	public void volumeUp() {
		//speaker = new SonySpeaker();
		speaker.volumeUp();
		//System.out.println("SamsungTV volumeUp");
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
		//System.out.println("SamsungTV volumeDown");
	}	
}
