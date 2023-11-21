/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

public interface DAO<E,I> {
    public int add(E bean);
    public int delete(Integer e);
    public int update(E bean);
    public int findAll(E bean);
}
