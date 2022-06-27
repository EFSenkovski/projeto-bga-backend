package br.com.eduardo.jobapi.exceptionhandler;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class JobAPIExceptionHandler extends ResponseEntityExceptionHandler{

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        // TODO Auto-generated method stub
        String mensagemUsuario = "Método ainda não suportado pela aplicação!"; //this.messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
        String mensagemDesenvolvedor = Optional.ofNullable(ex.getCause()).orElse(ex).toString();

        List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
        return handleExceptionInternal(ex, erros, headers, status, request);
    }

    public static class Erro {

        private LocalDateTime timestamp;
		private String mensagemUsuario;
		private String mensagemDesenvolvedor;        

		public String getMensagemUsuario() {
			return mensagemUsuario;
		}

		public LocalDateTime gettimestamp() {
            return timestamp;
        }

        public void settimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
        }

        public void setMensagemUsuario(String mensagemUsuario) {
			this.mensagemUsuario = mensagemUsuario;
		}

		public String getMensagemDesenvolvedor() {
			return mensagemDesenvolvedor;
		}

		public void setMensagemDesenvolvedor(String mensagemDesenvolvedor) {
			this.mensagemDesenvolvedor = mensagemDesenvolvedor;
		}

		public Erro(String mensagemUsuario, String mensagemDesenvolvedor) {
			this.mensagemUsuario = mensagemUsuario;
			this.mensagemDesenvolvedor = mensagemDesenvolvedor;            
            this.timestamp = LocalDateTime.now();
		}
	}
    
}
