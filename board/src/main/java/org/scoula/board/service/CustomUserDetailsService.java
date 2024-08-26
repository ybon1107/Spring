package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.board.domain.CustomUser;
import org.scoula.board.domain.MemberVO;
import org.scoula.board.mapper.BoardMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Log4j
@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final BoardMapper mapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberVO vo = mapper.get(username);
        if(vo == null) {
            throw new UsernameNotFoundException(username + "은 없는 id입니다.");
        }
        return new CustomUser(vo);
    }
}