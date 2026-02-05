import java.util.*;

public class RNASplicing {

    public static void main(String[] args) {
        //FASTA input
        Map<String, String> sequences = new LinkedHashMap<>();
        sequences.put("Rosalind_10", "ATGGTCTACATAGCTGACAAACAGCACGTAGCAATCGGTCGAATCTCGAGAGGCATATGGTCACATGATCGGTCGAGCGTGTTTCAAAGTTTGCGCCTAG");
        sequences.put("Rosalind_12", "ATCGGTCGAA");
        sequences.put("Rosalind_15", "ATCGGTCGAGCGTGT");

        //Identify main DNA and introns
        String dna = sequences.values().iterator().next(); // first sequence is main DNA
        List<String> introns = new ArrayList<>(sequences.values());
        introns.remove(0); // rest are introns

        //Remove introns
        for(String intron : introns) {
            dna = dna.replace(intron, "");
        }

        //Transcribe DNA to RNA
        String rna = dna.replace('T', 'U');

        //Codon table for translation
        Map<String, String> codonTable = new HashMap<>();
        codonTable.put("UUU","F"); codonTable.put("UUC","F");
        codonTable.put("UUA","L"); codonTable.put("UUG","L");
        codonTable.put("UCU","S"); codonTable.put("UCC","S");
        codonTable.put("UCA","S"); codonTable.put("UCG","S");
        codonTable.put("UAU","Y"); codonTable.put("UAC","Y");
        codonTable.put("UAA","Stop"); codonTable.put("UAG","Stop");
        codonTable.put("UGU","C"); codonTable.put("UGC","C");
        codonTable.put("UGA","Stop"); codonTable.put("UGG","W");
        codonTable.put("CUU","L"); codonTable.put("CUC","L");
        codonTable.put("CUA","L"); codonTable.put("CUG","L");
        codonTable.put("CCU","P"); codonTable.put("CCC","P");
        codonTable.put("CCA","P"); codonTable.put("CCG","P");
        codonTable.put("CAU","H"); codonTable.put("CAC","H");
        codonTable.put("CAA","Q"); codonTable.put("CAG","Q");
        codonTable.put("CGU","R"); codonTable.put("CGC","R");
        codonTable.put("CGA","R"); codonTable.put("CGG","R");
        codonTable.put("AUU","I"); codonTable.put("AUC","I");
        codonTable.put("AUA","I"); codonTable.put("AUG","M");
        codonTable.put("ACU","T"); codonTable.put("ACC","T");
        codonTable.put("ACA","T"); codonTable.put("ACG","T");
        codonTable.put("AAU","N"); codonTable.put("AAC","N");
        codonTable.put("AAA","K"); codonTable.put("AAG","K");
        codonTable.put("AGU","S"); codonTable.put("AGC","S");
        codonTable.put("AGA","R"); codonTable.put("AGG","R");
        codonTable.put("GUU","V"); codonTable.put("GUC","V");
        codonTable.put("GUA","V"); codonTable.put("GUG","V");
        codonTable.put("GCU","A"); codonTable.put("GCC","A");
        codonTable.put("GCA","A"); codonTable.put("GCG","A");
        codonTable.put("GAU","D"); codonTable.put("GAC","D");
        codonTable.put("GAA","E"); codonTable.put("GAG","E");
        codonTable.put("GGU","G"); codonTable.put("GGC","G");
        codonTable.put("GGA","G"); codonTable.put("GGG","G");

        //Translate RNA to Protein
        StringBuilder protein = new StringBuilder();
        for(int i = 0; i < rna.length() - 2; i += 3) {
            String codon = rna.substring(i, i + 3);
            String aa = codonTable.get(codon);
            if(aa.equals("Stop")) break;
            protein.append(aa);
        }

        //Output protein
        System.out.println(protein.toString());
    }
}
