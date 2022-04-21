바이트 단위 입력 스트림

>> InputStream <<
- byte단위에서 입력 스트림, 최상위 클래스 입니다.
- 많은 추상 메서드가 선언되어 있고 하위 스크림이 상속 받아 구현되어 있다.
- 주요 하위 클래스

fileinputStream : 파일에서 바이트 단위로 자료를 읽어 들인다.
byteArrayInputStream : byte 배열 메모리에서 바이트 단위로 자료를 읽는다.

- 주요 메서드
int read() : 입력 스트림으로 부터 한 바이트의 자료를 읽는다.
int read(byte b[]) : 입력 스트림으로 부터 b 배열의 크기의 자료를 읽는다.(읽은 자료의 바이트 수를 반환)
int read(byte b[], int offset, int length) : offset 변수(시작위치) 지정, length(길이)만큼 읽음 -> 읽은 바이트 수를 반환
void close(): 입력 스트림과 연결된 대상 리소스를 담는다.

