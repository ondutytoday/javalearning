package threads_golovach_labs.singleelementbuffer;

public class SingleElementBufferOptimized_A {
	private int waitedProducers = 0;
    private int waitedConsumers = 0;
    private Integer elem = null;

    public synchronized void put(Integer newElem) throws InterruptedException {
    	//��������� ����� ������� ������ ������
        while (elem != null) {
        	
            waitedProducers++;
            this.wait();
            waitedProducers--;
        }
        //������� �����
        this.elem = newElem;
        //�������� ���� �� � ������� �����������,�  ��� ����, ������ ���� �� ������
        //���� ������ ����������� �� �� ���� �� �����
        //���� ������ ����, �� �������� �� ������� 12, �������� ������� ���������� � ����� �����
        //� �� 32 �������   ���� ����������� � �� ������������
        if (waitedConsumers > 0) {
            this.notify();
        }
    }

    public synchronized Integer get() throws InterruptedException {
    	//������ �������, �������� �� ������ � �������� ����, � ������ �����
        while (elem == null) {
        	//�������� ���� � ������� ������������, �������� �������, ���
            waitedConsumers++;
            this.wait(); //���� ��� ���� �����
            waitedConsumers--;
        }
        int result = this.elem;
        this.elem = null;
        if (waitedProducers > 0) {
            this.notify();
        }
        return result;
    }
}
