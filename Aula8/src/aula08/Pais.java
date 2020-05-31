package aula08;

	public class Pais {
		private int id;
		private long populacao;
		private double area;
		private String nome;

		public Pais() {

		}

		public Pais(int id, String nome, long populacao, double area) {
			this.id = id;
			this.populacao = populacao;
			this.area = area;
			this.nome = nome;
		}

		public Pais(String nome, long populacao, double area) {
			this.populacao = populacao;
			this.area = area;
			this.nome = nome;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public long getPopulacao() {
			return populacao;
		}

		public void setPopulacao(long populacao) {
			this.populacao = populacao;
		}

		public double getArea() {
			return area;
		}

		public void setArea(double area) {
			this.area = area;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		@Override
		public String toString() {
			return "Pais [id=" + id + ", populacao=" + populacao + ", area=" + area + ", nome=" + nome + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pais other = (Pais) obj;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			if (populacao != other.populacao)
				return false;
			if (id != other.id)
				return false;
			if (area != other.area) 
				return false;
			return true;
		}
		
	}


