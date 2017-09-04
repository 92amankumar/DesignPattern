package pattern.creational.abstractfactory;

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

abstract class MMU {
	abstract void getType();
}

class X64MMU extends MMU {
	@Override
	void getType() {
		System.out.println(this.getClass().getName());
	}
}

class X86MMU extends MMU {
	@Override
	void getType() {
		System.out.println(this.getClass().getName());
	}
}

abstract class AbstractFactory {
	abstract CPU createCPU();

	abstract MMU createMMU();

	private static final X64Toolkit X64_TOOLKIT = new X64Toolkit();
	private static final X86Toolkit X86_TOOLKIT = new X86Toolkit();

	static AbstractFactory getFactory(Architecture architecture) {
		AbstractFactory factory = null;
		switch (architecture) {
		case X64:
			factory = X64_TOOLKIT;
			break;
		case X86:
			factory = X86_TOOLKIT;
			break;
		default:
			break;
		}
		return factory;
	}
}

class X64Toolkit extends AbstractFactory {

	@Override
	CPU createCPU() {
		return new X64CPU();
	}

	@Override
	MMU createMMU() {
		return new X64MMU();
	}
}

class X86Toolkit extends AbstractFactory {

	@Override
	CPU createCPU() {
		return new X86CPU();
	}

	@Override
	MMU createMMU() {
		return new X86MMU();
	}
}

enum Architecture {
	X64, X86
}

class ClientAbstractFactory {
	public static void main(String[] args) {
		AbstractFactory factory = AbstractFactory.getFactory(Architecture.X64);
		CPU cpu = factory.createCPU();
		cpu.getType();
	}
}