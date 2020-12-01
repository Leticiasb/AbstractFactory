public class FabricaAbstrataExemplo {

    public static void main(String[] args) {

        FabricaAbstrata fabrica1 = new FabricaConcreta1();
        Cliente cliente1 = new Cliente(fabrica1);
        cliente1.executar();

        FabricaAbstrata fabrica2 = new FabricaConcreta2();
        Cliente cliente2 = new Cliente(fabrica2);
        cliente2.executar();
    }
}



class Cliente {
    private ProdutoAbstratoA produtoA;
    private ProdutoAbstratoB produtoB;

    Cliente(FabricaAbstrata fabrica) {
        produtoA = fabrica.createProdutoA();
        produtoB = fabrica.createProdutoB();
    }

    void executar() {
        produtoB.interagir(produtoA);
    }
}

interface FabricaAbstrata {
    ProdutoAbstratoA createProdutoA();
    ProdutoAbstratoB createProdutoB();
}

interface ProdutoAbstratoA {

}

interface ProdutoAbstratoB {
    void interagir(ProdutoAbstratoA a);
}

class FabricaConcreta1 implements FabricaAbstrata {

    @Override
    public ProdutoAbstratoA createProdutoA() {
        return new ProdutoA1();
    }
    @Override
    public ProdutoAbstratoB createProdutoB() {
        return new ProdutoB1();
    }
}

class FabricaConcreta2 implements FabricaAbstrata {

    @Override
    public ProdutoAbstratoA createProdutoA() {
        return new ProdutoA2();
    }
    @Override
    public ProdutoAbstratoB createProdutoB() {
        return new ProdutoB2();
    }
}

class ProdutoA1 implements ProdutoAbstratoA {

}

class ProdutoB1 implements ProdutoAbstratoB {

    @Override
    public void interagir(ProdutoAbstratoA a) {
        System.out.println(this.getClass().getName() + " interage com " + a.getClass().getName());
    }

}

class ProdutoA2 implements ProdutoAbstratoA {

}

class ProdutoB2 implements ProdutoAbstratoB {

    @Override
    public void interagir(ProdutoAbstratoA a) {
        System.out.println(this.getClass().getName() + " interage com " + a.getClass().getName());
    }

}
