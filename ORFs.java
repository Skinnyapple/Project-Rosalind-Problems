import java.util.*;

public class ORFs {

    public static void main(String[] args) {
        //Sample DNA input
        String dna = "AGCCATGTAGCTAACTCAGGTTACATGGGGATGACCCCGCGACTTGGATTAGAGTCTCTTTTGGAATAAGCCTGAATGATCCGAGTAGCATCTCAG";

        Set<String> proteins = new HashSet<>();

        // Original DNA frames
        for(int frame = 0; frame < 3; frame++) {
            proteins.addAll(findORFs(dna, frame));
        }

        // Reverse complement DNA frames
        String revComp = reverseComplement(dna);
        for(int frame = 0; frame < 3; frame++) {
            proteins.addAll(findORFs(revComp, frame));
        }

        // Output all distinct proteins
        for(String protein : proteins) {
            System.out.println(protein);
        }
    }

    //Find ORFs in a DNA string starting from a given frame
    public static List<String> findORFs(String dna, int frame) {
        List<String> proteins = new ArrayList<>();
        Map<String,String> codonTable = getCodonTable();
        for(int i = frame; i <= dna.length() - 3; i += 3) {
            if(dna.substring(i,i+3).equals("ATG")) { // start codon
                StringBuilder protein = new StringBuilder();
                for(int j = i; j <= dna.length() - 3; j += 3) {
                    String codon = dna.substring(j,j+3);
                    String aa = codonTable.get(codon);
                    if(aa.equals("Stop")) break;
                    protein.append(aa);
                }
                if(protein.length() > 0) proteins.add(protein.toString());
            }
        }
        return proteins;
    }

    //Reverse complement
    public static String reverseComplement(String dna) {
        StringBuilder revComp = new StringBuilder();
        for(int i = dna.length() - 1; i >= 0; i--) {
            char c = dna.charAt(i);
            if(c == 'A') revComp.append('T');
            else if(c == 'T') revComp.append('A');
            else if(c == 'C') revComp.append('G');
            else if(c == 'G') revComp.append('C');
        }
        return revComp.toString();
    }

    //DNA codon table
    public static Map<String,String> getCodonTable() {
        Map<String,String> table = new HashMap<>();
        table.put("TTT","F"); table.put("TTC","F");
        table.put("TTA","L"); table.put("TTG","L");
        table.put("TCT","S"); table.put("TCC","S");
        table.put("TCA","S"); table.put("TCG","S");
        table.put("TAT","Y"); table.put("TAC","Y");
        table.put("TAA","Stop"); table.put("TAG","Stop");
        table.put("TGT","C"); table.put("TGC","C");
        table.put("TGA","Stop"); table.put("TGG","W");
        table.put("CTT","L"); table.put("CTC","L");
        table.put("CTA","L"); table.put("CTG","L");
        table.put("CCT","P"); table.put("CCC","P");
        table.put("CCA","P"); table.put("CCG","P");
        table.put("CAT","H"); table.put("CAC","H");
        table.put("CAA","Q"); table.put("CAG","Q");
        table.put("CGT","R"); table.put("CGC","R");
        table.put("CGA","R"); table.put("CGG","R");
        table.put("ATT","I"); table.put("ATC","I");
        table.put("ATA","I"); table.put("ATG","M");
        table.put("ACT","T"); table.put("ACC","T");
        table.put("ACA","T"); table.put("ACG","T");
        table.put("AAT","N"); table.put("AAC","N");
        table.put("AAA","K"); table.put("AAG","K");
        table.put("AGT","S"); table.put("AGC","S");
        table.put("AGA","R"); table.put("AGG","R");
        table.put("GTT","V"); table.put("GTC","V");
        table.put("GTA","V"); table.put("GTG","V");
        table.put("GCT","A"); table.put("GCC","A");
        table.put("GCA","A"); table.put("GCG","A");
        table.put("GAT","D"); table.put("GAC","D");
        table.put("GAA","E"); table.put("GAG","E");
        table.put("GGT","G"); table.put("GGC","G");
        table.put("GGA","G"); table.put("GGG","G");
        return table;
    }
}
