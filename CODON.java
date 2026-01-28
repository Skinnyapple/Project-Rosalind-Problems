public class CODON
{
    public static String translate(String rna)
    {
        String protein = "";

        for (int i = 0; i <= rna.length() - 3; i += 3)
        {
            String codon = rna.substring(i, i + 3);
            String amino = codonToAmino(codon);

            if (amino.equals("STOP"))
            {
                break;
            }

            protein += amino;
        }

        return protein;
    }

    private static String codonToAmino(String codon)
    {
        switch (codon)
        {
            case "UUU": case "UUC": return "F";
            case "UUA": case "UUG": case "CUU": case "CUC":
            case "CUA": case "CUG": return "L";
            case "AUU": case "AUC": case "AUA": return "I";
            case "AUG": return "M";
            case "GUU": case "GUC": case "GUA": case "GUG": return "V";
            case "UCU": case "UCC": case "UCA": case "UCG": return "S";
            case "CCU": case "CCC": case "CCA": case "CCG": return "P";
            case "ACU": case "ACC": case "ACA": case "ACG": return "T";
            case "GCU": case "GCC": case "GCA": case "GCG": return "A";
            case "UAU": case "UAC": return "Y";
            case "UAA": case "UAG": case "UGA": return "STOP";
            case "CAU": case "CAC": return "H";
            case "CAA": case "CAG": return "Q";
            case "AAU": case "AAC": return "N";
            case "AAA": case "AAG": return "K";
            case "GAU": case "GAC": return "D";
            case "GAA": case "GAG": return "E";
            case "UGU": case "UGC": return "C";
            case "UGG": return "W";
            case "CGU": case "CGC": case "CGA": case "CGG":
            case "AGA": case "AGG": return "R";
            case "AGU": case "AGC": return "S";
            case "GGU": case "GGC": case "GGA": case "GGG": return "G";
        }
        return "";
    }
}
