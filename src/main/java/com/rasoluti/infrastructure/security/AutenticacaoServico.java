package com.rasoluti.infrastructure.security;

//@Service
public class AutenticacaoServico{ //implements UserDetailsService {

//    @Autowired private ParametrosRepository parametrosIntegracaoDao;
//
//    /* ------------------------------------------------------------------------------------------------------*/
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        try {
//
//            final String CATEGORIA_PARAMETRO = "PABX-ATENDER";
//            final String NOME_PARAMETRO = "CREDENCIAIS_FUJIOKA";
//
//            List<Parametros> parametrosAutenticacao =
//                    parametrosIntegracaoDao.listarPorCategoriaENomeParametro(
//                            CATEGORIA_PARAMETRO, NOME_PARAMETRO);
//
//            if (parametrosAutenticacao.isEmpty()) {
//
//                throw new ApiException(
//                        "Não foi possível obter as credenciais de autenticação. Favor verificar os parâmetros.",
//                        HttpStatus.BAD_REQUEST);
//            }
//
//            boolean possuiMaisDeUmParametro = parametrosAutenticacao.size() > 1;
//            if (possuiMaisDeUmParametro) {
//
//                throw new ApiException(
//                        "Mais de um parâmetro de autenticação foi encontrado. Favor verificar os parâmetros.",
//                        HttpStatus.CONFLICT);
//            }
//
//            Parametros parametroAutenticacao =
//                    parametrosAutenticacao.stream().findFirst().get();
//
//            UserDetails usuarioDetalhe = this.retornaDadosDescriptografados(parametroAutenticacao);
//
//            return usuarioDetalhe;
//
//        } catch (Exception e) {
//
//   
//            throw new ApiException(e);
//        }
//    }
//
//    /* ------------------------------------------------------------------------------------------------------*/
//
//    private UserDetails retornaDadosDescriptografados(Parametros parametroAutenticacao)
//            throws Exception {
//
//        Objects.requireNonNull(parametroAutenticacao, "Parâmetro de autenticação não pode ser nulo");
//        String valorParametro =
//                Objects.requireNonNull(
//                                parametroAutenticacao.getValor(), "Valor do parâmetro não pode ser nulo")
//                        .trim();
//
//        String valorParametroDecode = Base64.base64Decode(valorParametro);
//
//        String usuario = valorParametroDecode.split(":")[0];
//        String senha = valorParametroDecode.split(":")[1];
//
//        UsuarioAplicacao usuarioAplicacao =
//                UsuarioAplicacao.builder().usuario(usuario).senha(senha).build();
//
//        return usuarioAplicacao;
//    }

    /* ------------------------------------------------------------------------------------------------------*/

}
