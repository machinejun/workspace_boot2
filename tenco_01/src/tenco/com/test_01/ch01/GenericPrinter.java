package tenco.com.test_01.ch01;

public class GenericPrinter <T> {
	// T 라는 대체 문자를 사용, > E - element, K - key, V - value (아무 문자나 가능하지만 맞춰 쓰는 걸 권장)
	private T material;

	public T getMaterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
	}
}
