package enumconverter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import enumerator.Sexo;

@Converter(autoApply = true)
public class SexoConverter implements AttributeConverter<Sexo, String>{
	
	@Override
	public String convertToDatabaseColumn(Sexo sexo) 
	{
		switch (sexo) 
		{
			case Masculino: 		
				return "M"; 
			case Feminino:
				return "F";
			default: throw new IllegalArgumentException("Unknown" + sexo);
		}
	}

	@Override
	public Sexo convertToEntityAttribute(String sexo) {

		switch (sexo)
		{
			case "M": 
				return Sexo.Masculino;
			case "F":
				return Sexo.Feminino;
			default: throw new IllegalArgumentException("Unknown" + sexo);
		}
	}
}