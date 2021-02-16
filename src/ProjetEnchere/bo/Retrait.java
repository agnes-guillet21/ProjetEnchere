package ProjetEnchere.bo;

public class Retrait {
	
	   private int no_retrait;// auto generer
	    private String rue;
	    private String codePostal;
	    private String ville;

	   
	    //construc
	
	    public Retrait() {
		}
	    
//    public Retrait(int no_retrait, String rue, String codePostal, String ville) {
//	        
//	        this.rue = rue;
//	        this.codePostal = codePostal;
//	        this.ville = ville;
//	        this.no_retrait=no_retrait;
//	    }

	    public Retrait( String rue, String codePostal, String ville) {
	        
	        this.rue = rue;
	        this.codePostal = codePostal;
	        this.ville = ville;
	    }

	   
	   //getter setter
	    public int getNo_retrait() {
				return no_retrait;
			}

			public void setNo_retrait(int no_retrait) {
				this.no_retrait = no_retrait;
			}


		public String getRue() {
	        return rue;
	    }

	

		public void setRue(String rue) {
	        this.rue = rue;
	    }

	    public String getCodePostal() {
	        return codePostal;
	    }

	    public void setCodePostal(String codePostal) {
	        this.codePostal = codePostal;
	    }

	    public String getVille() {
	        return ville;
	    }

	    public void setVille(String ville) {
	        this.ville = ville;
	    }

	    @Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Retrait [no_retrait=");
			builder.append(no_retrait);
			builder.append(", rue=");
			builder.append(rue);
			builder.append(", codePostal=");
			builder.append(codePostal);
			builder.append(", ville=");
			builder.append(ville);
			builder.append("]");
			return builder.toString();
		}
	    
	}