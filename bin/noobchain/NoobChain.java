//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package noobchain;

import java.util.ArrayList;

public class NoobChain {
    public static ArrayList<Block> blockchain = new ArrayList();
    public static int difficulty = 5;

    public NoobChain() {
    }

    public static void main(String[] args) {
        System.out.println("Trying to Mine block 1... ");
        addBlock(new Block("Hi im the first block", "0"));
        System.out.println("Trying to Mine block 2... ");
        addBlock(new Block("Yo im the second block", ((Block)blockchain.get(blockchain.size() - 1)).hash));
        System.out.println("Trying to Mine block 3... ");
        addBlock(new Block("Hey im the third block", ((Block)blockchain.get(blockchain.size() - 1)).hash));
        System.out.println("\nBlockchain is Valid: " + isChainValid());
        String blockchainJson = StringUtil.getJson(blockchain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);
    }

    public static Boolean isChainValid() {
        String hashTarget = (new String(new char[difficulty])).replace('\u0000', '0');

        for(int i = 1; i < blockchain.size(); ++i) {
            Block currentBlock = (Block)blockchain.get(i);
            Block previousBlock = (Block)blockchain.get(i - 1);
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes not equal");
                return false;
            }

            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous Hashes not equal");
                return false;
            }

            if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
                System.out.println("This block hasn't been mined");
                return false;
            }
        }

        return true;
    }

    public static void addBlock(Block newBlock) {
        newBlock.mineBlock(difficulty);
        blockchain.add(newBlock);
    }
}