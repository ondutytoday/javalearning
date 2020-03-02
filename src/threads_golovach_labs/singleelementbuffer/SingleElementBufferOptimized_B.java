package threads_golovach_labs.singleelementbuffer;

public class SingleElementBufferOptimized_B {
	private Integer elem = null;

    public synchronized void put(Integer newElem) throws InterruptedException {
        while (elem != null) {
            this.wait();
            if (elem != null) {
                this.notify();
            }
        }
        //����� ������� ������� � ����-�� ������
        //�������� ������ ���� �� ����� � ������ ���� �� �������� � ��� �� ������������� ����� ��������
        this.elem = newElem;
        this.notify();
    }

    public synchronized Integer get() throws InterruptedException {
    	//����� ���� ���� ���� � �������� ���� ���
        while (elem == null) {
        	//����� ����
            this.wait();
            if (elem == null) {
                this.notify();
            }
        }
        int result = this.elem;
        this.elem = null;
        this.notify();
        return result;
    }
}
