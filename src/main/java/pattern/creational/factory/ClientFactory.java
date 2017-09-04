package pattern.creational.factory;

abstract class CPU {
	abstract void getType();
}

class X64CPU extends CPU {

	@Override
	void getType() {
		System.out.println(this.getClass().getName());
	}
}

class X86CPU extends CPU {
	@Override
	void getType() {
		System.out.println(this.getClass().getName());
	}
}

class Factory {
	static CPU getCPU(Architecture architecture) {
		CPU cpu = null;
		switch (architecture) {
		case X64:
			cpu = new X64CPU();
			break;
		case X86:
			cpu = new X86CPU();
			break;
		default:
			break;
		}
		return cpu;
	}
}

enum Architecture {
	X64, X86
}

class ClientFactory {
	public static void main(String[] args) {
		CPU cpu = Factory.getCPU(Architecture.X86);
		cpu.getType();
	}
}