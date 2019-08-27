/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2018.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen JiMi Network Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2018年12月19日    TanLianWang         Create the class
 * http://www.jimilab.com/
*/

package com.dlnu.byname.annotation;

import java.lang.annotation.*;

/**
 * @FileName MyAnnotation.java
 * @Description: 
 *
 * @Date 2018年12月19日 下午3:17:39
 * @author TanLianWang
 * @version 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {

}
