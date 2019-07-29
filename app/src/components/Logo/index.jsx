import React, { PureComponent } from 'react';
import logoImg from './floor-msg-manage (1).svg';
import styles from './index.less';
class Logo extends PureComponent {
  render() {
    return (
      <div className={styles.logoContainer}>
        <img className={styles.logo} src={logoImg} alt="logo" />
        <br />
        <span className={styles.title}>DMS</span>
      </div>
    );
  }
}

export default Logo;
